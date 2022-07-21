import Annoucements from "./Annoucements";
import HomeContent from "./HomeContent";
import Results from "./Results";
import Schedule from "./Schedule";

const Home = () => {
    return (
        <div>
            <HomeContent/>
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
        </div>
    );
}
 
export default Home;