import React from 'react';
import {Link} from 'react-router';
export default class ProductData extends React.Component{
	onSubmitDelete(e){
		e.preventDefault()
		console.log("Delete on submit")
		this.props.deleteById({id:this.props.productData.id})
	}
	
    render(){
        return <div>
        
            
            <Link to={`/editProduct1/${this.props.productData.id}`} className="btn btn-success">Edit Product</Link>
       
            <Link to={`/`} className="btn btn-success">
            <button type='submit' className="btn btn-success" onClick={this.onSubmitDelete.bind(this)}>Delete</button>
            </Link>
            
           
            <h1>ProductId:{this.props.productData.id}</h1><hr/>
            <h3>Name:{this.props.productData.name}</h3><hr/>
            <h3>Id:{this.props.productData.id}</h3><hr/>
            <h3>Type:{this.props.productData.type}</h3><hr/>
            <h3>Expiry Date ( as Strings):{this.props.productData.expiry}</h3><hr/>
           
            

        </div>
    }
}