package infy.org.m1.service.ClientImpl;

import infy.org.m1.dto.ProductDto;
import infy.org.m1.service.client.M2Client;
import infy.org.m1.service.client.M3Client;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class M2ClientFallback implements M2Client {

    private final M3Client m3Client;

    public M2ClientFallback(M3Client m3Client) {
        this.m3Client = m3Client;
    }

    @Override
    public List<ProductDto> getProductFromM2(@RequestParam String category, @RequestParam int limit) {
        return m3Client.getProductFromM2(category, limit);
    }
}
