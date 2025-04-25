function createDiplomeCard() {
    const container = document.getElementById("diplomes");
    const index = container.children.length;

    const div = document.createElement("div");
    div.className = "col-12 mb-3";
    div.innerHTML = `
        <div class="p-3 border rounded shadow-sm bg-white">
            <input type="text" name="diplomes[${index}].titre" class="form-control mb-2" placeholder="Titre" required>
            <input type="text" name="diplomes[${index}].institution" class="form-control mb-2" placeholder="Institution" required>
            <input type="date" name="diplomes[${index}].dateDelivrance" class="form-control mb-2" required>
        </div>
    `;
    container.appendChild(div);
}
function createLangueCard() {
    const container = document.getElementById("langues");
    const index = container.children.length;

    const div = document.createElement("div");
    div.className = "col-12 mb-3";
    div.innerHTML = `
        <div class="p-3 border rounded shadow-sm bg-white">
            <input type="text" name="langues[${index}].nom" class="form-control mb-2" placeholder="Langue" required>
            <select name="langues[${index}].niveau" class="form-select mb-2" required>
                <option value="" disabled selected>Choisir un niveau</option>
                <option value="Debutant">Débutant</option>
                <option value="Intermediaire">Intermédiaire</option>
                <option value="Fluent">Fluent</option>
                <option value="Natif">Natif</option>
            </select>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="langues[${index}].isMaitrise">
                <label class="form-check-label">Maîtrisé</label>
            </div>
        </div>
    `;
    container.appendChild(div);
}
function createCertificatCard() {
    const container = document.getElementById("certificats");
    const index = container.children.length;

    const div = document.createElement("div");
    div.className = "col-12 mb-3";
    div.innerHTML = `
        <div class="p-3 border rounded shadow-sm bg-white">
            <input type="text" name="certificats[${index}].titre" class="form-control mb-2" placeholder="Titre" required>
            <input type="text" name="certificats[${index}].organisation" class="form-control mb-2" placeholder="Organisation" required>
            <input type="date" name="certificats[${index}].dateDelivrance" class="form-control mb-2" required>
        </div>
    `;
    container.appendChild(div);
}
function createExperienceCard() {
    const container = document.getElementById("experiences");
    const index = container.children.length;

    const div = document.createElement("div");
    div.className = "col-12 mb-3";
    div.innerHTML = `
        <div class="p-3 border rounded shadow-sm bg-white">
            <input type="text" name="experiences[${index}].type" class="form-control mb-2" placeholder="Type d'expérience" required>
            <input type="date" name="experiences[${index}].dateDebut" class="form-control mb-2" required>
            <input type="date" name="experiences[${index}].dateFin" class="form-control mb-2">
            <input type="text" name="experiences[${index}].description" class="form-control mb-2" placeholder="Description" required>
        </div>
    `;
    container.appendChild(div);
}
function createCompetenceCard() {
    const container = document.getElementById("competences");
    const index = container.children.length;

    const div = document.createElement("div");
    div.className = "col-12 mb-3";
    div.innerHTML = `
        <div class="p-3 border rounded shadow-sm bg-white">
            <input type="text" name="competences[${index}].nom" class="form-control mb-2" placeholder="Nom de compétence" required>
            <input type="text" name="competences[${index}].description" class="form-control mb-2" placeholder="Description" required>
            <input type="number" min="0" max="100" name="competences[${index}].pourcentage" class="form-control mb-2" placeholder="Niveau (%)" required>
        </div>
    `;
    container.appendChild(div);
}