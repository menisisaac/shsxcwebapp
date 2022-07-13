import {Link} from 'react-router-dom';

const Navbar = () => {

    return (
        <div>
            <nav className="navbar">
                <h1>SHS XCTF</h1>
                <div className="links">
                    <Link to='/'>Home</Link>
                    <Link to='/xc'>Cross Country</Link>
                    <Link to='indoortf'>Indoor Track</Link>
                    <Link to='outdoortf'>Outdoor Track</Link>
                    <Link to='grout'>Grout Invitational</Link>
                    <Link to='futures'>Futures Meet</Link>
                </div>
            </nav>
        </div>
    );
}
 
export default Navbar;