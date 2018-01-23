

export default function products(state=[],action){
    switch(action.type){
        case 'FETCH_PRODUCTS':
        return action.products
        
        case 'SAVE_PRODUCTS':
        state.push(action.saved)
        console.log(state)
        return state
        
        case 'UPDATE_PRODUCTS':
        return "STUDENT_UPDATED"
        
        case 'FETCH_PRODUCTS_BY_NAME':
        return action.products	
        
        case 'DELETING_PRODUCTS':
        	 state.push(action.saved)
             console.log(state)
             return state
        	
        default:
        return state;
    }
}