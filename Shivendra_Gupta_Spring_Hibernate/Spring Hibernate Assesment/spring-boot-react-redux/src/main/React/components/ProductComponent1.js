import React from 'react';
import ProductData from './ProductDetailsComponent'; 
export default class Product extends React.Component{

    render(){

        var name =this.props.params.name;
        console.log(name)
        console.log(this.props.myproducts)
        var index=this.props.myproducts.findIndex((u)=>{
            if(u.name==name)
            return true;
        })

        var currProduct=this.props.myproducts[index];

        return <div>
            <ProductData {...this.props} productData={currProduct} i={index}/>
        </div>
    }
}