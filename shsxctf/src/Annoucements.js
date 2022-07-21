import AnnoucementList from "./AnnoucementList";
import useFetch from "./useFetch";

const Annoucements = () => {
    const {data, isPending, error} = useFetch("http://192.168.1.16/api/admin/announcement");
    return (
        <div className='annoucements'>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <AnnoucementList annoucements={data}/> }
        </div>
    );
}
 
export default Annoucements;