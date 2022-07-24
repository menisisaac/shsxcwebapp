import Annoucements from "./Annoucements";
import Schedule from "./Schedule";
import useFetch from "./useFetch";

const HomeContent = (props) => {
    const next = props.next;
    return (
        <div className="homeBanner">
        <div className='containerTwo'>
            <div className="nextMeet">
                <h1>Next Meet</h1>
                <h2>{next[0].name}</h2>
                <p>Location: {next[0].location}</p>
                <p>Date: {next[0].date} Time: {next[0].time}</p>
            </div>
            <div>
                <img className='image 'src="https://pbs.twimg.com/media/FDx_7RSWUAMXXaD?format=jpg&name=large" />
            </div>
            </div>
        </div>
    );
}
 
export default HomeContent;