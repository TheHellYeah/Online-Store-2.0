<#include "rating-mini.ftlh">

<#macro rev review>
    <div class="border rounded container m-1">
        <div class="row">
            <p class="text-warning">${review.author.username} <@ratingmini product.rating /></p>
        </div>

        <p class="text-white">${review.description}</p>
        <p class="text-white mr-0">${review.date}</p>
    </div>
</#macro>