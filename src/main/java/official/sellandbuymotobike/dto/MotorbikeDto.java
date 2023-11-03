package official.sellandbuymotobike.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotorbikeDto implements Serializable {
    private int price;
    private String status;
    private String licensePlates;
    private  int odometer;
}
