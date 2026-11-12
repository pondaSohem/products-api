package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    ProductService()
    {
        products.add(new DigitalProduct(nextId++, "xteink book library membership", 109.99,
                "/here/there/e-ink-stuff.pdf", 5.2));
        products.add(new PhysicalProduct(nextId++, "xteink x4 pro", 109.99, 2,
                "200mmX150mmX30mm"));
    }

    public List<Product> getAllProducts()
    {
        return products;
    }

    public Product addProduct(Product product)
    {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id)
    {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteProduct(Long id)
    {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name)
    {
        return products.stream().filter(p -> p.getName().contains(name)).toList();
    }

    public List<String> getAllSummaries()
    {
        List<String> loopArray = new ArrayList<>();
        for (Product product : products)
        {
            loopArray.add(product.getSummary());
        }

        return loopArray;
    }
}
