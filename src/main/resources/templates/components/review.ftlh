<#macro rev review>
    <div class="border rounded container">
        <p class="text-warning">${review.author.username} // Оценка ${review.mark}</p>
        <p class="text-white">${review.description}</p>
        <p class="text-white mr-0">${review.date}</p>
    </div>
</#macro>