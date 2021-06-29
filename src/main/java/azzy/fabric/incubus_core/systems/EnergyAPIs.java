package azzy.fabric.incubus_core.systems;

import azzy.fabric.incubus_core.IncubusCoreCommon;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class EnergyAPIs {
    public static final BlockApiLookup<HeatIo, @NotNull Direction> HEAT =
            BlockApiLookup.get(new Identifier(IncubusCoreCommon.MODID, "heat_system"), HeatIo.class, Direction.class);

    //public static final BlockApiLookup<MechanicalIo, @NotNull Direction> MECHANICAL =
    //        BlockApiLookup.get(new Identifier(IncubusCoreCommon.MODID, "mechanical_system"), MechanicalIo.class, Direction.class);
//
    //public static final BlockApiLookup<PressureIo, @NotNull Direction> PRESSURE =
    //        BlockApiLookup.get(new Identifier(IncubusCoreCommon.MODID, "pressure_system"), PressureIo.class, Direction.class);

    public static long pressureInverse(double pressure) {
        if(pressure <= 0) {
            return 0;
        }
        return (long) Math.max(0, (Math.sqrt(pressure) * 36586.544243));
    }

    public static double accelerationFromPressureGradient(double self, double other) {
        return Math.sqrt(Math.abs(self - other)) * ((self < other) ? -1 : 1);
    }
}
