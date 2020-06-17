<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="activate">
<@bootstrap.navbar/>
<div class="container col-4 mt-5">
    <h3><@spring.message code="activate"/></h3>
    <form action="/activate" method="get">
        <div class="form-group">
            <label for="code"><@spring.message code="activate.code"/>:</label>
            <input type="text" name="code" class="form-control" id="code"
                   placeholder='<@spring.message code="activate.placeholder"/>' required>
        </div>
        <button type="submit" class="btn btn-warning mb-1"><@spring.message code="activate.button"/></button>
    </form>
</div>
</@component.skeleton>