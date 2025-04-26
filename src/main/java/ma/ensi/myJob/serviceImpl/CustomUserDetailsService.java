package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Personne;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RecruteurService recruteurService;

    @Autowired
    private CandidatService candidatService;

    // todo
    // create those classes then import
    //    @Autowired
    //    private CandidatRepository candidatRepository;
    //
    //    @Autowired
    //    private AdminRepository adminRepository;

    @Override
             public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Check in Recruteur
        Recruteur recruteur = recruteurService.findByEmail(email);

        if (recruteur != null) {
            System.out.println("Loaded recruteur: " + recruteur.getUserName());
            return buildUserDetails(recruteur);
        }
// Check in Candidat
        Candidat candidat = candidatService.findByEmail(email);
        if(candidat != null) {
            System.out.println("Loaded candidate: " + candidat.getUserName());
            return buildUserDetails(candidat);
        }
        ///fixme

        //        // Check in Admin
        //        Optional<Admin> admin = adminRepository.findByEmail(email);
        //        if (admin.isPresent()) {
        //            return buildUserDetails(admin.get());
        //        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }

    private UserDetails buildUserDetails(Personne personne) {
        System.out.println("you creds are");
        System.out.println(personne.getUserName());
        System.out.println(personne.getMdp());
        return new User(
                personne.getUserName(),
                personne.getMdp(),
                getAuthorities(personne.getRole())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }
    }
