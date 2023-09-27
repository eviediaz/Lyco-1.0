"use strict";

var connection = new signalR.HubConnectionBuilder().withUrl("/chatHub").build();
var tipoUsuario = document.getElementById('username1').innerText;
var tabID = 1;
var username = "";
var pos;
var mode;




//La funcion que se ejecuta cada que se recibe un mensaje del hub
connection.on("ReceiveMessage", function (mode, message, editorID) {

    console.log("Se recibe el editor " + editorID);
    var editor = ace.edit(editorID);

    editor.setOption("mode", mode);

    //Setea el texto y coloca el cursor en donde estaba
    editor.getSession().setValue(message, 1);
    editor.gotoLine(pos.row + 1, pos.column);
});


//Recibe la sena de que se debe crear una nueva pestana
connection.on("ReceivePage", function (tabID, modeValue, nomArchivo) {

    $('#tab-list').append($('<li class="active nav-item nav-link"><a href="#tab' + tabID + '" role="tab" data-toggle="tab">' + nomArchivo + '<button class="close" type="button" title="Borrar página">×</button></a></li>'));
    $('#tab-content').append($('<div class="tab-pane fade editor-container col-xl-12 col-md-12 col-sm-12 col-12" id="tab' + tabID + '"><div class="aceEditor" id="editor-' + tabID + '"></div></div>'));

    var editor = 'editor-' + tabID;
    editor = ace.edit(editor);
    editor.setTheme("ace/theme/cobalt");
    editor.session.setMode(modeValue);
    if (tipoUsuario == '1') { editor.setReadOnly(true); }
});


//Recibe la sena de que se debe ELIMINAR una nueva pestana
connection.on("ErasePage", function (atabID) {
    $('a[href="' + atabID + '"]').parents('li').remove();
    $(atabID).remove();
});

connection.start().then(function () {
}).catch(function (err) {
    return console.error(err.toString());
});

//"Listener" del editorAce que sucde en cada entrada/input
$('#tab-content').on('input', '.aceEditor', function (e) {

    //Reconocer de donde viene el mensaje
    var editorID = $(this).attr('id');
    var editor = ace.edit(editorID);

    //Almacena el usuario y el mensaje
    var message = editor.getValue();

    //Obtiene la ubicacion del cursor
    pos = editor.selection.getCursor();

    //Obtiene el lenguaje
    var mode = editor.getSession().getMode().$id;

    //Envia el usuario y el mensaje al comando "SendMessage"
    connection.invoke("SendMessage", mode, message, editorID).catch(function (err) {
        return console.error(err.toString());
    });
});



//"Listener" del editorAce que sucede en cada tecla apretada/'keyup'
$('#tab-content').on('keyup', '.aceEditor', function (e) {
    if (e.keyCode === 32 || e.ctrlKey && e.keyCode === 86 ||
        e.ctrlKey && e.keyCode === 88 || e.keyCode === 8 || e.keyCode === 46) {

        //Reconocer de donde viene el mensaje
        var editorID = $(this).attr('id');
        var editor = ace.edit(editorID);

        //Almacena el usuario y el mensaje
        var message = editor.getValue();

        //Obtiene la ubicacion del cursor
        pos = editor.selection.getCursor();

        //Obtiene el lenguaje
        var mode = editor.getSession().getMode().$id;

        //Envia el usuario y el mensaje al comando "SendMessage"
        connection.invoke("SendMessage", mode, message, editorID).catch(function (err) {
            return console.error(err.toString());
        });
    }
});


$('#addPestanaSesion').click(function () {
    tabID++;

    var nomArchivo = document.getElementById('nomArchivo').value;
    var modeSelect = document.getElementById('mode');
    var modeValue = modeSelect.options[modeSelect.selectedIndex].value;

    connection.invoke("CreatePage", tabID, modeValue, nomArchivo).catch(function (err) {
        return console.error(err.toString());
    });
});

$('#tab-list').on('click', '.close', function () {
    var atabID = $(this).parents('a').attr('href');

    connection.invoke("DeletePage", atabID).catch(function (err) {
        return console.error(err.toString());
    });

});
