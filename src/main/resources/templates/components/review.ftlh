<#include "rating-mini.ftlh">

<#macro rev review>
    <div class="border rounded container m-1" style="font-size: 20px;">
        <div class="row ml-1 mt-2 ">
            <p class="text-warning"><a href="/user/${review.author.id}">${review.author.username}</a> <@ratingmini product.rating /></p>
        </div>
        <div class="row">
            <div class="m-2" style="width: 75px;height: 75px;">
                <img style=" width:100%; height:100%;" src="/avatars/${review.author.avatar}">
            </div>
                <p style="float:left;" class="col-9 text-white">${review.description}</p>
                <p class="text-white mr-0">${review.date}</p>
        </div>

    </div>
</#macro>