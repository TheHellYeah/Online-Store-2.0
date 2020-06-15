<#macro navbar>
<#include "security.ftlh">
<nav class="navbar navbar-expand-lg sticky-top">
    <a class="navbar-brand" href="/"><span class="text-white">Shoe</span><span class="text-dark bg-warning rounded">Hub</span></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link text-white" href="/?category=MAN"><@spring.message code="navbar.man"/><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/?category=WOMAN"><@spring.message code="navbar.woman"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/?category=CHILD"><@spring.message code="navbar.child"/></a>
            </li>
            <li  class="nav-item">
                <a class="nav-link text-white" href="?lang=ru">RU</a>
            </li>
            <li  class="nav-item">
                <a class="nav-link text-white" href="?lang=en">EN</a>
            </li>
        </ul>

        <#if !known>
        <button class="btn-sm btn-warning  my-2 my-sm-0 mr-2"><a class="text-dark" href="/activate" ><@spring.message code="activate.button"/></a></button>
        <button class="btn btn-warning  my-2 my-sm-0 mr-2"><a class="text-dark" href="/login" ><@spring.message code="sign.in"/></a></button>
        <#else>
        <div class="mr-3">
            <span class="text-warning">${user.balance} ₽</span>
            <svg class="bi bi-wallet2" width="2em" height="2em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                <path d="M2.5 4l10-3A1.5 1.5 0 0 1 14 2.5v2h-1v-2a.5.5 0 0 0-.5-.5L5.833 4H2.5z"/>
                <path fill-rule="evenodd" d="M1 5.5A1.5 1.5 0 0 1 2.5 4h11A1.5 1.5 0 0 1 15 5.5v8a1.5 1.5 0 0 1-1.5 1.5h-11A1.5 1.5 0 0 1 1 13.5v-8zM2.5 5a.5.5 0 0 0-.5.5v8a.5.5 0 0 0 .5.5h11a.5.5 0 0 0 .5-.5v-8a.5.5 0 0 0-.5-.5h-11z"/>
            </svg>
        </div>
        <div class="mr-3">
            <a href="/user/cart" style="text-decoration: none;"><@spring.message code="navbar.cart"/>
                <svg class="bi bi-cart4" width="2em" height="2em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                </svg>
             </a>
        </div>
    <#if admin || seller>
        <div class="mr-3">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="admin-dropdown" role="button" style="text-decoration: none;"><@spring.message code="navbar.management"/>
                <svg class="bi bi-hammer" width="2em" height="2em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path d="M9.812 1.952a.5.5 0 0 1-.312.89c-1.671 0-2.852.596-3.616 1.185L4.857 5.073V6.21a.5.5 0 0 1-.146.354L3.425 7.853a.5.5 0 0 1-.708 0L.146 5.274a.5.5 0 0 1 0-.706l1.286-1.29a.5.5 0 0 1 .354-.146H2.84C4.505 1.228 6.216.862 7.557 1.04a5.009 5.009 0 0 1 2.077.782l.178.129z"/>
                    <path fill-rule="evenodd" d="M6.012 3.5a.5.5 0 0 1 .359.165l9.146 8.646A.5.5 0 0 1 15.5 13L14 14.5a.5.5 0 0 1-.756-.056L4.598 5.297a.5.5 0 0 1 .048-.65l1-1a.5.5 0 0 1 .366-.147z"/>
                </svg>
            </a>
            <div class="dropdown-menu dropdown-menu-right mt-0 mr-5 bg-dark text-warning" aria-labelledby="admin-dropdown" style="right: 45px;">
                <a class="dropdown-item" href="/product/add"><@spring.message code="navbar.management.add"/></a>
                <a class="dropdown-item" href="/seller/orders"><@spring.message code="navbar.management.orders"/></a>
                <a class="dropdown-item" href="/storage"><@spring.message code="navbar.management.storage"/></a>
                <#if admin>
                    <a class="dropdown-item" href="/admin"><@spring.message code="navbar.management.admin"/></a>
                </#if>
             </div>
        </div>
    </#if>
        <div>
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="dropdown" style="text-decoration: none;">${name}
                <svg class="bi bi-person-fill" width="2em" height="2em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                </svg>
            </a>
            <div class="dropdown-menu dropdown-menu-right mt-0 mr-2 bg-dark text-warning" aria-labelledby="dropdown">
                <a class="dropdown-item" href="/user/${userId}"><@spring.message code="navbar.dropdown.personal"/></a>
                <a class="dropdown-item" href="/user/${userId}/wishlist"><@spring.message code="navbar.dropdown.wishlist"/>
                    <svg class="bi bi-star-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                    </svg>
                </a>
                <a class="dropdown-item" href="/user/orders"><@spring.message code="navbar.dropdown.orders.list"/>
                    <svg class="bi bi-card-checklist" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                        <path fill-rule="evenodd" d="M7 5.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0zM7 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0z"/>
                    </svg>
                </a>
                <form action="/logout" method="post">
                    <a class="dropdown-item" href="#" onclick="this.parentNode.submit();"><@spring.message code="navbar.dropdown.logout"/>
                        <svg class="bi bi-box-arrow-in-left" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M7.854 11.354a.5.5 0 0 0 0-.708L5.207 8l2.647-2.646a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708 0z"/>
                            <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0 0 1h9A.5.5 0 0 0 15 8z"/>
                            <path fill-rule="evenodd" d="M2.5 14.5A1.5 1.5 0 0 1 1 13V3a1.5 1.5 0 0 1 1.5-1.5h8A1.5 1.5 0 0 1 12 3v1.5a.5.5 0 0 1-1 0V3a.5.5 0 0 0-.5-.5h-8A.5.5 0 0 0 2 3v10a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-1.5a.5.5 0 0 1 1 0V13a1.5 1.5 0 0 1-1.5 1.5h-8z"/>
                        </svg>
                    </a>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            </div>
        </div>
    </#if>
    </div>
</nav>
</#macro>