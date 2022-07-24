import Annoucements from "./Annoucements";
import UploadFiles from "./FileUploadPage";
import HomeContent from "./HomeContent";
import Results from "./Results";
import Schedule from "./Schedule";
import useFetch from "./useFetch";

const Home = () => {
    const {data, isPending, error} = useFetch("https://www.shsxctf.com/api/schedule/schedule");
    return (
        <div>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <HomeContent next={data}/>}
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
            <UploadFiles/>
        </div>
    );
}
 
export default Home;