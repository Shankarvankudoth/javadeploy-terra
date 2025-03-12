document.addEventListener("DOMContentLoaded", function () {
    // Example: Add a confirmation dialog before submitting the form
    const form = document.querySelector("form");
    if (form) {
        form.addEventListener("submit", function (event) {
            const confirmed = confirm("Are you sure you want to submit the form?");
            if (!confirmed) {
                event.preventDefault(); // Prevent form submission
            }
        });
    }
});