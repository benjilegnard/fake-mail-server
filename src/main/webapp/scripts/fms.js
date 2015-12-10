(function(window,$,_,Backbone, Handlebars){
    //basic namespace
    var FMS = {};

    //BackBone models
    FMS.Server = Backbone.Model.extend({
        "defaults":{
            "host":"127.0.0.1",
            "port":25000,
            "status":"stopped"
        }
    });

    FMS.Message = Backbone.Model.extend({
        "defaults":{
            "from":"test@test.com",
            "to":"test@test.com",
            "subject":"TEST",
            "body":"",
            "mime":"",
            "read":false
        }
    });

    FMS.Info = Backbone.Model.extend({
        "defaults":{
            "level":"alert",
           "content":""
        }
    });

    //collections
    FMS.Messages = Backbone.Collection.extend({
        url: '/messages'
    });
    FMS.FlashInfos = Backbone.Collection.extend({});

    FMS.MessageListView = Backbone.View.extend({
        collection : FMS.Messages,
        render:function(evt){
    Handlebars.compile()
        },
        initialize:function(evt){

        }
    });

    FMS.FlashInfosView = Backbone.View.extend({
        collection: FMS.Messages
    });

    FMS.MessageDetailsView = Backbone.View.extend({
        model : FMS.Message
    });

    FMS.ServerFormView = Backbone.View.extend({
        model : FMS.Server
    });

    FMS.Router = Backbone.Router.extend({
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
        new FMS.Router();
        Backbone.history.start({pushState: true});
        FMS.views = {};
        FMS.views.serverForm = new FMS.ServerFormView({model : new FMS.Server(),el:'#server-form'});
        FMS.views.flashInfos = new FMS.MessageDetailsView({collection : new FMS.Messages(),el:'#messages-list'});
        FMS.views.messageList = new FMS.MessageDetailsView({collection : new FMS.Messages(),el:'#messages-list'});
    });

    FMS.socket = new WebSocket("ws://localhost:8888/fms/live");

    window.FMS = FMS;

})(window,jQuery,_,Backbone, Handlebars);