
var list = document.getElementById("tab-list");
new Sortable(list);

var editor = 'editor-1';
editor = ace.edit(editor);
editor.setTheme("ace/theme/cobalt");

//Define tipo de usuario que entrara a usar el hub
$(document).ready(function () {

    var tipoUsuario = document.getElementById('username1').innerText;
    if (tipoUsuario === "") {
        alert("Nulo");
        return;
    }

    var editor = 'editor-1';
    editor = ace.edit(editor);

    if (tipoUsuario == '2') {
        editor.setReadOnly(false);
    } else {
        editor.setReadOnly(true);
        editor.commands.removeCommand('showSettingsMenu');
    }

});