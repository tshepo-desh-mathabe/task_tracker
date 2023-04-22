import { EventEmitter } from 'events';
import dispatcher from "./AppDispatcher";
import STORE_CONST from '../constants/store_constants.json';

const name = 'CHANGE';

class AppStore extends EventEmitter {
    constructor() {
        super();

        this.data = {
            user: { roles: [], token: '', userDetails: {} },
            isLoading: { flag: false, content: '' },
            isMessaging: { messageIcon: '', messageFlag: false, messageTopic: '', messageContent: '' }
        }
        // Registers action handler with the dispatcher. 
        dispatcher.register(this.registerToActions.bind(this));
    }

    // Switches over the action's type when an action is dispatched. 
    registerToActions(action) {
        switch (action.actionType) {
            case STORE_CONST.userDetails:
                this.setUserDetails(action.payload);
                break;
            case STORE_CONST.loader:
                this.setLoader(action.payload);
                break;
            case STORE_CONST.messager:
                this.setMessage(action.payload);
                break;
            default:
                break;
        }
    }

    setUserDetails(payload) {
        this.data.user = payload;
        this.emit(name);
    }

    setLoader(data) {
        let loader = this.data.isLoading;
        loader.flag = data.flag;
        loader.content = data.content;
        this.emit(name);
    }

    setMessage(data) {
        let message = this.data.isMessaging;
        message.messageIcon = data.icon;
        message.messageFlag = data.flag;
        message.messageTopic = data.topic;
        message.messageContent = data.content;
        this.emit(name);
    }

    getUserToken() {
        return this.data.user.token;
    }

    getLoader() {
        return this.data.isLoading;
    }

    getMessage() {
        return this.data.isMessaging;
    }

    addChangeListener(callback) {
        this.on(name, callback);
    }

    removeChangeListener(callback) {
        this.removeListener(name, callback);
    }

    getAll() {
        return this.data;
    }

}

const appStore = new AppStore();

export default appStore;