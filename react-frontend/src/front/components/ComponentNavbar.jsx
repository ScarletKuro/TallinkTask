import React from 'react';
import {Link} from 'react-router-dom';

const ComponentNavbar = () => (
    <nav className="navbar navbar-default">
        <div className="navbar-brand"><Link to={'/'}>Tallink Conference</Link></div>
    </nav>
);

export default ComponentNavbar;
