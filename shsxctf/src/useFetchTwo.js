import { useEffect, useState } from "react";


const useFetchTwo = (url) => {
    const[dataTwo, setData] = useState(null);
    const[isPendingTwo, setIsPending] = useState(true);
    const[errorTwo, setError] = useState(null);

    useEffect(() => {
    const abortCont = new AbortController();
    fetch(url)
    .then(res => {
        if(!res.ok) {
            throw Error("Couldn't fetch data for that resource");
        }
        return res.json();
    })
    .then(data => {
        setData(data);
        setIsPending(false);
        setError(null);
    })
    .catch(err => {
        if(err.name === 'AbortError') {
            console.log('fetch aborted');
        }
        setIsPending(false);
        setError(err.message);
    })
    }, [url]);
    return {dataTwo, isPendingTwo, errorTwo}
}

export default useFetchTwo