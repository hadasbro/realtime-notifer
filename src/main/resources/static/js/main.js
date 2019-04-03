
/* ---------  javascript pseudocode example ------- */

function post(url, data) {
    return $.ajax({
        type: 'POST',
        url: url,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(data)
    })
}

function appendMessage(message) {
    var fromNow = moment(message.time).format('HH:mm:ss');

    var toUserId = typeof message.toUserId != "undefined" ? ('user ID: '+message.toUserId+', session: '+message.toUsessToken) : 'from';

    if (typeof message.new != "undefined"){
        toUserId = '';
    }

    var $message = $('<li class="clearfix"><div class="message-data ' + (toUserId == '' ? 'align-left': 'align-right') + '"><span class="message-data-name">'+toUserId+'</span><span class="message-data-time">'+fromNow+'</span></div><div class="message '+(toUserId == '' ? 'my-message': 'other-message float-right')+' ">'+message.message+'</div></li>');

    var $messages = $('#messages');
    $messages.append($message);
    $messages.scrollTop($messages.prop("scrollHeight"));
}

//for user-session-id
function getPreviousMessagesForUsess(usessId) {
    $.get('/notifer/get-messages',{usessId:usessId}).done(messages => messages.forEach(appendMessage));
}
//for user-session-id
function getPreviousMessagesAll(usessId) {
    $.get('/notifer/get-messages-all').done(messages => messages.forEach(appendMessage));
}

function sendMessageTo() {
    var $messageInput = $('#messageInput');
    var $messageToHash = $('#userHashInput');
    var choosenOpt = $('#userHashInput').find('option[value='+$messageToHash.val()+']');

    var message = {message: $messageInput.val(), toUserId: choosenOpt.data('uid'), toUsessToken: choosenOpt.data('sesstoken')};

    $messageInput.val('');
    post('/notifer', message);
    appendMessage(message);

    return false;
}

function onNewMessage(result) {
    var message = JSON.parse(result.body);
    message.new = 1;
    appendMessage(message);
}

function connectWebSocket(userId, sessionToken) {

    var socket = new SockJS('/notifyWS');
    stompClient = Stomp.over(socket);
    //stompClient.debug = null;
    stompClient.connect({}, (frame) => {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/channel/'+userId+'/'+sessionToken+'/messages', onNewMessage);
    });
}


function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

$(function(){
    var panelType = $('#panel-type').val();

    if(panelType == 'send') {
            getPreviousMessagesAll();
    } else if(panelType == 'client') {

        $('#chooseUser').change(function(e){
            if ($(this).val() > 0) {

                // Do something for option "b"
                var url = window.location.href;

                if (url.indexOf("?") > 0) {
                    url = url.substring(0, url.indexOf("?"));
                }

                if (url.indexOf('?') > -1){
                   url += '&usersess='+$(this).val();
                }else{
                   url += '?usersess='+$(this).val()
                }

                window.location.href = url;

            }
        })

        //if specific user has logged in
        if($('#user_id_subscribe').length > 0 && $('#user_session_subscribe').length > 0) {

            var uSessId = $('#user_id_subscribe_show').val();

            var user_id_subscribe = $('#user_id_subscribe').val();
            var user_session_subscribe = $('#user_session_subscribe').val(); //token


            getPreviousMessagesForUsess(uSessId);
            connectWebSocket(user_id_subscribe, user_session_subscribe);

            $('#logInAs').text('You are logged in as: [user: '+user_id_subscribe+'] [session: '+user_session_subscribe + ']').show();
        }


    } else{
    }
})
