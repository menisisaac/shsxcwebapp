import AnnoucementList from "./AnnoucementList";
import useFetch from "./useFetch";

const Annoucements = () => {
    const {data, isPending, error} = useFetch("https://www.shsxctf.com/api/admin/announcement");
    return (
        <div className='annoucements'>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <AnnoucementList annoucements={data}/> }
        </div>
    );
}
 
export default Annoucements;