(function(window,$,_,Backbone, Handlebars){
    //basic namespace
    var SMTP = {};

    //BackBone models
    SMTP.Server = Backbone.Model.extend({
        "defaults":{
            "host":"127.0.0.1",
            "port":25000,
            "status":"stopped"
        }
    });

    SMTP.Message = Backbone.Model.extend({
        "defaults":{
            "from":"test@test.com",
            "to":"test@test.com",
            "subject":"TEST",
            "body":"",
            "mime":"",
            "read":false
        }
    });

    SMTP.Info = Backbone.Model.extend({
        "defaults":{
            "level":"alert",
           "content":""
        }
    });

    //collections
    SMTP.Messages = Backbone.Collection.extend({
        url: '/messages'
    });
    SMTP.FlashInfos = Backbone.Collection.extend({});

    SMTP.MessageListView = Backbone.View.extend({
        collection : SMTP.Messages,
        render:function(evt){
    Handlebars.compile()
        },
        initialize:function(evt){

        }
    });

    SMTP.FlashInfosView = Backbone.View.extend({
        collection: SMTP.Messages
    });

    SMTP.MessageDetailsView = Backbone.View.extend({
        model : SMTP.Message
    });

    SMTP.ServerFormView = Backbone.View.extend({
        model : SMTP.Server
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

    $(document).ready(function(event){
        console.log("Starting SMTP app : ");
        console.trace(event);
        new SMTP.Router();
        Backbone.history.start({pushState: true});
        SMTP.views = {};
        SMTP.views.serverForm = new SMTP.ServerFormView({model : new SMTP.Server(),el:'#server-form'});
        SMTP.views.flashInfos = new SMTP.MessageDetailsView({collection : new SMTP.Messages(),el:'#messages-list'});
        SMTP.views.messageList = new SMTP.MessageDetailsView({collection : new SMTP.Messages(),el:'#messages-list'});
    });

    SMTP.socket = new WebSocket("ws://localhost:9001/smtp/live");

    window.SMTP = SMTP;

})(window,jQuery,_,Backbone, Handlebars);