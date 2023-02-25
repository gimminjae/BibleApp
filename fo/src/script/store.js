import {createStore} from 'vuex'

// Create a new store instance.
const store = createStore({
    state() {
        return {
            user: {
                id: 0,
                memName: "",
                role: "UNKNOWN",
                //회원 정보는 필요한 최소한의 정보만 가지고 있는 것이 좋다
            }
        }
    }
    ,
    mutations: {
        setUser(state, payload) {
            state.user.id = payload.memberIdx;
            state.user.memName = payload.name;
            state.user.role = payload.role;
        }
        ,
        removeUser(state) {
            state.user.id = 0;
            state.user.memName = "";
            state.user.role = "UNKNOWN";
        }
    }
})

export default store;
