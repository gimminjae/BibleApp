import {createStore} from 'vuex'

// Create a new store instance.
const store = createStore({
    state() {
        return {
            user: {
                id: 0,
                memName: "",
                role: "",
                //회원 정보는 필요한 최소한의 정보만 가지고 있는 것이 좋다
            }
        }
    }
    ,
    mutations: {
        setUser(state, payload) {
            console.log(payload);
            state.user.id = payload.memIdx;
            state.user.memName = payload.memName;
            state.user.role = payload.role;
            console.log(state.user);
        }
        ,
        removeUser(state) {
            state.user.id = 0;
            state.user.memName = "";
            state.user.role = "";
        }
    }
})

export default store;
