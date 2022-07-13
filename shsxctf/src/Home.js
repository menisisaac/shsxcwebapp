import Annoucements from "./Annoucements";
import Results from "./Results";
import Schedule from "./Schedule";

const Home = () => {
    return (
        <div className='container'>
            <div className='col grid_1_of_3'>
                <Schedule/>
            </div>
            <div className='col grid_2_of_3'>
                <Annoucements/>
            </div>
            <div className='col grid_3_of_3'>
                <Results/>
            </div>
        </div>
    );
}
 
export default Home;