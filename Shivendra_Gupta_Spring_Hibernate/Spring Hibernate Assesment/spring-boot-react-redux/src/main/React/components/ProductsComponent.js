import React from 'react';
import AllProduct from './AllProductComponent';


export default class Products extends React.Component{
    render(){
        var allProducts=this.props.myproducts.map((u,index)=>{
            return <li><AllProduct {...this.props} allProduct={u} i={index}/></li>
        })

        return <div>
            <h2>All Products </h2>
            <ul>
            {allProducts}
            </ul>
        </div>
    }
}