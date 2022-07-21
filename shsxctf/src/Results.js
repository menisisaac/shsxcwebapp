import ResultList from "./ResultList";
import useFetch from "./useFetch";

const Results = () => {
    const {data, isPending, error} = useFetch("http://192.168.1.16/api/result/result/url");
    return (
        <div className='results'>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <ResultList results={data}/> }
        </div>
    );
}
 
export default Results;