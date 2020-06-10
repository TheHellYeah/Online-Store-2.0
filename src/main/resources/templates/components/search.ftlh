<#import "/spring.ftl" as spring>
<#macro form>
<div class="container mt-3">
    <div class="row">
        <div class="dropdown">
            <button class="btn btn-warning dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                <@spring.message code="search"/>
                <svg class="bi bi-search" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
                    <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
                </svg>
            </button>
            <div id="dropdown-search" class="dropdown-menu dropdown-search">
                <form class="px-4 py-2" action="/">
                    <div class="input-group">
                        <input type="search" class="form-control" name="searchQuery" id="product-search-input" placeholder='<@spring.message code="search.placeholder"/>' autofocus="autofocus">
                        <div class="input-group-append">
                            <button class="btn btn-warning" type="submit"><@spring.message code="find"/></button>
                        </div>
                    </div>
                </form>
                <div id="search-items">
                    <div class="text-white ml-3"><@spring.message code="search.result"/>:</div>
                </div>
        </div>
        <span style="font-size: 20px;">
                <a href="/?sortOrder=ASC&sortBy=price"><@spring.message code="asc"/></a>
                <a href="/?sortOrder=DESC&sortBy=price"><@spring.message code="desc"/></a>
                <a href="/?sortOrder=DESC&sortBy=rating"><@spring.message code="popularity"/></a>
        </span>
    </div>
</div>
</#macro>