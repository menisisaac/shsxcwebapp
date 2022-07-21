import Annoucements from "./Annoucements";
import Schedule from "./Schedule";

const HomeContent = () => {
    return (
        <div className="homeBanner">
        <div className='containerTwo'>
            <div className="nextMeet">
                <h1>Next Meet</h1>
                <h2>Grout Invitational</h2>
                <p>Location: Central Park, Schenectady NY</p>
                <p>Time: 9:00AM</p>
            </div>
            <div>
                <img className='image 'src="https://pbs.twimg.com/media/FDx_7RSWUAMXXaD?format=jpg&name=large" />
            </div>
            </div>
        </div>
    );
}
 
export default HomeContent;