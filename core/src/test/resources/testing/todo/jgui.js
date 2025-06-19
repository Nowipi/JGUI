
document.querySelectorAll('button, input[type="checkbox"]').forEach(element => {
    element.addEventListener("click", (event) => {
        interact(event.target.id);
    });
});

document.querySelectorAll('input[type="text"]').forEach(element => {
    element.addEventListener("change", (event) => {
        change(event.target.id, event.target.value);
    });
});

function change(id, value) {
    console.log("Change: " + id);
    fetch("/", {
        method: "POST",
        headers: {
            'Content-Type': 'text/plain',
            'Component-ID': id,
        },
        body: value
    }).then(response => {
        if (response.ok) {
            const el = document.getElementById(response.headers.get('Container-ID'))
            response.text().then(body => {
                el.innerHTML = body;
            });
        }
    })
}

function interact(id) {
    console.log("Interact: " + id);
    fetch("/", {
        method: "POST",
        headers: {
            'Component-ID': id,
        },
    }).then(response => {
        if (response.redirected) {
            window.location.href = response.url;
        }
    });
}