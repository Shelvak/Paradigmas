/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.io.Serializable;

/**
 *
 * @author RotseN
 */
public class Engine extends Component {
    public int cylinder_quantity;
    public int displacement;
    
    public Engine(int cylinder_quantity, int displacement) {
        this.cylinder_quantity = cylinder_quantity;
        this.displacement = displacement;
    }
}
