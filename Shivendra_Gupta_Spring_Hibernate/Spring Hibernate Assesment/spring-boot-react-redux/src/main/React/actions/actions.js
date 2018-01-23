import axios from 'axios';


export function fetchProductsData(){
    console.log('fetching products deta')
    var request=axios.get('/products');
    return (dispatch)=>{
        request.then((response)=>{
            console.log("hey"+response.data);
            dispatch({type:'FETCH_PRODUCTS',products:response.data})
        })
    }
}

export function saveProductsData(product){
    console.log('saving products details')
    var request=axios.post('/products',product);
    return (dispatch)=>{
        request.then((response)=>{
            console.log(response.data);
            dispatch({type:'SAVE_PRODUCTS',saved:response.data})
        })
    }
}

export function updateProductsData(product){
	console.log('updating products details')
	var request=axios.put('/products',product);
	return (dispatch)=>{
        request.then((response)=>{
            console.log(response.data);
            dispatch({type:'UPDATE_PRODUCTS',saved:response.data})
        })
    }
}

export function findByName(name){
    console.log('fetching products details')
    var request=axios.get('/products/'+name.name);
    return (dispatch)=>{
        request.then((response)=>{
            console.log("In find Name"+response.data);
            dispatch({type:'FETCH_PRODUCTS_BY_NAME',products:response.data})
        })
    }
}
export function deleteById(id){
    console.log('deleting products details')
    var request=axios.delete('/delete/'+id.id);
    return (dispatch)=>{
        request.then((response)=>{
            console.log("hey"+response.data);
            dispatch({type:'DELETING_PRODUCTS',products:response.data})
        })
    }
}