/*
 * File created ~ 24 - 4 - 2021 ~ Leaf
 */

package leaf.cosmere.manifestation.surgebinding;

import leaf.cosmere.Cosmere;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cosmere.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SurgeAbrasion extends SurgebindingBase
{
    public SurgeAbrasion(int color)
    {
        super(color);
    }


    //change frictional force

}
