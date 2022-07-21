import ResultList from "./ResultList";
import useFetch from "./useFetch";

const Results = () => {
    const {data, isPending, error} = useFetch("https://www.shsxctf.com/api/result/result/url");
    return (
        <div className='results'>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <ResultList results={data}/> }
        </div>
    );
}
 
export default Results;