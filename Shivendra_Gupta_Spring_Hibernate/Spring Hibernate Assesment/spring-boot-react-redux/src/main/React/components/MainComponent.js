import React from 'react';
import {Link} from 'react-router';
export default class Main extends React.Component{
    componentDidMount(){
        this.props.fetchProductsData();
    }

    render(){
        return <div className="container">
            <h1>Product Retail Management</h1>
            <nav className="nav nav-tabs">
            <a href="/" className="btn btn-success">All Products Page</a>
            
            <Link to={`/newProduct`} className="btn btn-success">New Product Form</Link>
            <Link to={`/searchId`} className="btn btn-success">Search Id</Link>
            <Link to={`/searchName`} className="btn btn-success">Search Name</Link>
            </nav>
            {React.cloneElement(this.props.children,this.props)}
        </div>
    }
}