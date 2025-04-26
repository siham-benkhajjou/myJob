document.addEventListener('DOMContentLoaded', () => {
    // Initialize the CV sections with empty fields (if applicable)
    initializeCVSections();
});

function createDiplomeCard() {
    const diplomesContainer = document.getElementById("diplomes");
    const newDiplome = document.createElement("div");
    newDiplome.classList.add("col-md-6");
    newDiplome.innerHTML = `
        <div class="card">
            <div class="card-body">
                <div class="form-group">
                    <label for="diplomeTitle">Titre du Diplôme</label>
                    <input type="text" name="diplomeTitle" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="diplomeInstitution">Institution</label>
                    <input type="text" name="diplomeInstitution" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="diplomeYear">Année de délivrance</label>
                    <input type="text" name="diplomeYear" class="form-control" required>
                </div>
            </div>
        </div>
    `;
    diplomesContainer.appendChild(newDiplome);
}

function createLangueCard() {
    const languesContainer = document.getElementById("langues");
    const newLangue = document.createElement("div");
    newLangue.classList.add("col-md-6");
    newLangue.innerHTML = `
        <div class="card">
            <div class="card-body">
                <div class="form-group">
                    <label for="langueName">Nom de la Langue</label>
                    <input type="text" name="langueName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="langueLevel">Niveau</label>
                    <input type="text" name="langueLevel" class="form-control" required>
                </div>
            </div>
        </div>
    `;
    languesContainer.appendChild(newLangue);
}

function createCertificatCard() {
    const certificatsContainer = document.getElementById("certificats");
    const newCertificat = document.createElement("div");
    newCertificat.classList.add("col-md-6");
    newCertificat.innerHTML = `
        <div class="card">
            <div class="card-body">
                <div class="form-group">
                    <label for="certificatTitle">Titre du Certificat</label>
                    <input type="text" name="certificatTitle" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="certificatOrganization">Organisation</label>
                    <input type="text" name="certificatOrganization" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="certificatYear">Année d'obtention</label>
                    <input type="text" name="certificatYear" class="form-control" required>
                </div>
            </div>
        </div>
    `;
    certificatsContainer.appendChild(newCertificat);
}

function createExperienceCard() {
    const experiencesContainer = document.getElementById("experiences");
    const newExperience = document.createElement("div");
    newExperience.classList.add("col-md-6");
    newExperience.innerHTML = `
        <div class="card">
            <div class="card-body">
                <div class="form-group">
                    <label for="experienceTitle">Titre de l'expérience</label>
                    <input type="text" name="experienceTitle" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="experienceCompany">Entreprise</label>
                    <input type="text" name="experienceCompany" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="experienceStart">Date de début</label>
                    <input type="text" name="experienceStart" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="experienceEnd">Date de fin</label>
                    <input type="text" name="experienceEnd" class="form-control" required>
                </div>
            </div>
        </div>
    `;
    experiencesContainer.appendChild(newExperience);
}