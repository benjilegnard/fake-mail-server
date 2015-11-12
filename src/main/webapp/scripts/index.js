(function(window,$,Backbone){
    //basic namespace
    var SMTP = {};

    //BackBone models
    SMTP.ServerModel = Backbone.Model.extend({
        "defaults":{
            "host":"127.0.0.1",
            "port":25000,
            "status":"stopped"
        }
    });

    SMTP.MessageModel = Backbone.Model.extend({
        "defaults":{
            "from":"test@test.com",
            "to":"test@test.com",
            "subject":"TEST",
            "body":"",
            "mime":"",
            "read":false
        }
    });

    SMTP.MessageCollection = Backbone.Collection.extend({
        url: '/messages'
    });

    SMTP.MessageListView = Backbone.View.extend({
        model : SMTP.MessageCollection
    });

    SMTP.MessageDetailView = Backbone.View.extend({
        model : SMTP.MessageModel
    });

    SMTP.ServerFormView = Backbone.View.extend({
        model : SMTP.ServerModel
    });

    SMTP.Router = Backbone.Router.extend({
        "routes":{
            "":"messageList",
            "messages":"messageList",
            "message/:id":"messageDetail"
        },
        "messageList":function(){
            console.log("messageList");
        },
        "messageDetails":function(id){
            console.log("messageDetails : " + id);

        }
    });

    function domReady(event){
        console.log("Starting SMTP app : ");
        console.trace(event);
        new SMTP.Router();
        Backbone.history.start({pushState: true})
    }

    SMTP.socket = new WebSocket("ws://localhost:9001/smtp/live");

    document.addEventListener('DOMContentLoaded', domReady);

    window.SMTP = SMTP;

})(window,jQuery,Backbone);