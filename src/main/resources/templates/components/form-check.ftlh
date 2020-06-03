<#macro checkbox name value text>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" name=${name} value=${value} id=${value}>
        <label class="form-check-label" for=${value}>
            ${text}
        </label>
    </div>
</#macro>