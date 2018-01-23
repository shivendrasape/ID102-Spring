import React from 'react';
import {Link} from 'react-router';
export default class AllProduct extends React.Component{

    render(){
        return <div>
        <Link to={`/view/${this.props.allProduct.id}`}>
        <h3 className="btn btn-success">{this.props.allProduct.name}</h3>
         </Link>
         </div>
    }
}