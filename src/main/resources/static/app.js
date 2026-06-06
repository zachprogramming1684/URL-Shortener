const shortenBtn = document.getElementById('shortenBtn');
const urlInput = document.getElementById('urlInput');
const resultArea = document.getElementById('resultArea');
const shortLink = document.getElementById('shortLink');

shortenBtn.addEventListener('click', () => {

    const longUrl = urlInput.value;

    if (!longUrl) {
        alert("Please enter a URL!");
        return;
    }

    fetch('http://localhost:8080/shorten', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ "originalUrl": longUrl })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Looks like that wasn't a valid URL!");
            }
            return response.json();
        })
        .then(data => {

            const fullShortUrl = `http://localhost:8080/${data.shortCode}`;

            shortLink.innerText = fullShortUrl;
            shortLink.href = fullShortUrl;

            resultArea.classList.remove('hidden');

            urlInput.value = '';
        })
        .catch(error => {
            alert(error.message);
        });
});