<#macro checkbox name value text>
    <div class="custom-control custom-checkbox">
        <input class="custom-control-input" type="checkbox" name=${name} value=${value} id=${value}>
        <label class="custom-control-label" for=${value}>
            ${text}
        </label>
    </div>
</#macro>