import { Link } from "react-router-dom";

const TestNavBar = () => {
    return (
<nav class="navbar navbar-expand-lg bg-dark navbar-dark" >
  <div class="container-fluid">
    <Link class="navbar-brand" to="/">Schenectady XCTF</Link>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <Link class="nav-link active" aria-current="page" to="/xc">Cross Country</Link>
        <Link class="nav-link" to="/indoortf">Indoor Track</Link>
        <Link class="nav-link" to="/outdoortf">Outdoor Track</Link>
        <Link class="nav-link" to="/grout">Grout Invitational</Link>
        <Link class="nav-link" to="/info">Team Information</Link>
      </div>
    </div>
  </div>
</nav>
    );
}
 
export default TestNavBar;