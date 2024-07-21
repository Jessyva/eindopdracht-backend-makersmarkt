import React, { useState, useEffect } from 'react';
import ‘./ProductOndernemerPage.css';

const ProductOndernemerPage = ({ match }) => {
    const [ProductOndernemer, setProductOndernemer] = useState(null);

    useEffect(() => {
        const fetchProductOndernemer = async () => {
            const response = await fetch(`https://api.example.com/ProductOndernemer/${match.params.id}`);
            const data = await response.json();
            setProductOndernemer(data);
        };

        fetchProductOndernemer();
    }, [match.params.id]);

    if (!ProductOndernemer) {
        return <div>Loading...</div>;
    }

    return (
        <div className="ProductOndernemerpage">
            <h2>{ProductOndernemer.name}</h2>
            <p>Locatie: {ProductOndernemer.location}</p>
            <h3>Producten</h3>
            <ul>
                {ProductOndernemer.products.map((product, index) => (
                    <li key={index}>{product}</li>
                ))}
            </ul>
            <p>Website: <a href={ProductOndernemer.website}>{ProductOndernemerwebsite}</a></p>
            <p>Social Media: {ProductOndernemer.socialMedia}</p>
            <div className="photos">
                {ProductOndernemer.photos.map((photo, index) => (
                    <img key={index} src={photo} alt={`Product ${index}`} />
                ))}
            </div>
        </div>
    );
};

export default ProductOndernemerPage;
