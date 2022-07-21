import {Link} from 'react-router-dom';

const Navbar = () => {

    return (
        <div>
            <nav className="navbar">
                <Link className="homeLink" to='/'>Schenectady XCTF</Link>
                <div className="links">
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