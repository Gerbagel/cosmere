/*
 * File created ~ 24 - 4 - 2021 ~ Leaf
 */

package leaf.cosmere.registry;

import leaf.cosmere.Cosmere;
import leaf.cosmere.constants.Metals;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AttributesRegistry
{
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Cosmere.MODID);

    public static final Map<String, RegistryObject<Attribute>> COSMERE_ATTRIBUTES = makeAttributeMap();


    public static final CreatureAttribute SPREN = new CreatureAttribute();

    public static Map<String, RegistryObject<Attribute>> makeAttributeMap()
    {
        Map<String, RegistryObject<Attribute>> attributeModifiers = new HashMap<>();

        for (Metals.MetalType metalType : Metals.MetalType.values())
        {
            if (!metalType.hasAssociatedManifestation())
                continue;

            String mistingNamePath = metalType.getMistingName();
            String ferringNamePath = metalType.getFerringName();


            RegistryObject<Attribute> mistingAttribute = ATTRIBUTES.register(
                    mistingNamePath.toLowerCase(),
                    () -> (new RangedAttribute(
                            Cosmere.MODID + "." + mistingNamePath.toLowerCase(),
                            0,
                            0,
                            1000)).setSyncable(true)
            );

            RegistryObject<Attribute> ferringAttribute = ATTRIBUTES.register(
                    ferringNamePath.toLowerCase(),
                    () -> (new RangedAttribute(
                            Cosmere.MODID + "." + ferringNamePath.toLowerCase(),
                            0,
                            0,
                            1000)).setSyncable(true)
            );

            attributeModifiers.put(mistingNamePath, mistingAttribute);
            attributeModifiers.put(ferringNamePath, ferringAttribute);
        }

        final String tinName = Metals.MetalType.TIN.getName();
        RegistryObject<Attribute> tin_senses_attribute = ATTRIBUTES.register(
                tinName,
                () -> (new RangedAttribute(
                        Cosmere.MODID + "." + tinName,
                        0,
                        0,
                        1)).setSyncable(true)
        );
        attributeModifiers.put(tinName, tin_senses_attribute);

        return attributeModifiers;
    }



}
