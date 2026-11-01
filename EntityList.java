import java.util.HashMap;
import java.util.Map;

public class EntityList {
   private static Map b = new HashMap();
   private static Map c = new HashMap();
   private static Map d = new HashMap();
   private static Map e = new HashMap();
   private static Map f = new HashMap();
   public static HashMap a = new HashMap();

   private static void a(Class par0Class, String par1Str, int par2) {
      b.put(par1Str, par0Class);
      c.put(par0Class, par1Str);
      d.put(par2, par0Class);
      e.put(par0Class, par2);
      f.put(par1Str, par2);
   }

   private static void a(Class par0Class, String par1Str, int par2, int par3, int par4) {
      a(par0Class, par1Str, par2);
      a.put(par2, new hr(par2, par3, par4));
   }

   public static Entity a(String par0Str, World par1World) {
      Entity entity = null;

      try {
         Class class1 = (Class)b.get(par0Str);
         if (class1 != null) {
            entity = (Entity)class1.getConstructor(World.class).newInstance(par1World);
         }
      } catch (Exception exception) {
         exception.printStackTrace();
      }

      return entity;
   }

   public static Entity a(ady par0NBTTagCompound, World par1World) {
      Entity entity = null;

      try {
         Class class1 = (Class)b.get(par0NBTTagCompound.j("id"));
         if (class1 != null) {
            entity = (Entity)class1.getConstructor(World.class).newInstance(par1World);
         }
      } catch (Exception exception) {
         exception.printStackTrace();
      }

      if (entity != null) {
         entity.e(par0NBTTagCompound);
      } else {
         System.out.println("Skipping Entity with id " + par0NBTTagCompound.j("id"));
      }

      return entity;
   }

   public static Entity a(int par0, World par1World) {
      Entity entity = null;

      try {
         Class class1 = (Class)d.get(par0);
         if (class1 != null) {
            entity = (Entity)class1.getConstructor(World.class).newInstance(par1World);
         }
      } catch (Exception exception) {
         exception.printStackTrace();
      }

      if (entity == null) {
         System.out.println("Skipping Entity with id " + par0);
      }

      return entity;
   }

   public static int a(Entity par0Entity) {
      return (Integer)e.get(par0Entity.getClass());
   }

   public static String b(Entity par0Entity) {
      return (String)c.get(par0Entity.getClass());
   }

   public static String a(int par0) {
      Class class1 = (Class)d.get(par0);
      return class1 != null ? (String)c.get(class1) : null;
   }

   static {
      a(EntityItem.class, "Item", 1);
      a(EntityXPOrb.class, "XPOrb", 2, 7864183, 16777079);
      a(EntityPainting.class, "Painting", 9, 16777215, 0);
      a(EntityArrow.class, "Arrow", 10, 16777215, 0);
      a(uq.class, "Snowball", 11, 16777215, 13421772);
      a(EntityFireball.class, "Fireball", 12, 16755285, 16733508);
      a(EntitySmallFireball.class, "SmallFireball", 13, 16755285, 16733508);
      a(adw.class, "ThrownEnderpearl", 14, 5583803, 16738047);
      a(EntityEnderEye.class, "EyeOfEnderSignal", 15, 5583803, 16738047);
      a(EntityPotion.class, "ThrownPotion", 16, 7829503, 3355647);
      a(EntityExpBottle.class, "ThrownExpBottle", 17, 7864183, 16777079);
      a(agg.class, "PrimedTnt", 20, 16711680, 16777215);
      a(EntityFallingSand.class, "FallingSand", 21, 16777215, 0);
      a(EntityMinecart.class, "Minecart", 40, 5592405, 10066329);
      a(EntityBoat.class, "Boat", 41, 16777215, 0);
      a(EntityLiving.class, "Mob", 48, 44975, 8930372);
      a(EntityMob.class, "Monster", 49, 44975, 8930372);
      a(yd.class, "Creeper", 50, 894731, 0);
      a(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
      a(cb.class, "Spider", 52, 3419431, 11013646);
      a(EntityGiantZombie.class, "Giant", 53, 44975, 7969893);
      a(EntityZombie.class, "Zombie", 54, 44975, 7969893);
      a(EntitySlime.class, "Slime", 55, 5349438, 8306542);
      a(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
      a(alt.class, "PigZombie", 57, 15373203, 5009705);
      a(EntityEnderman.class, "Enderman", 58, 1447446, 0);
      a(fn.class, "CaveSpider", 59, 803406, 11013646);
      a(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
      a(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
      a(aic.class, "LavaSlime", 62, 3407872, 16579584);
      a(EntityDragon.class, "EnderDragon", 63, 5636182, 0);
      a(qr.class, "Pig", 90, 15771042, 14377823);
      a(cu.class, "Sheep", 91, 15198183, 16758197);
      a(un.class, "Cow", 92, 4470310, 10592673);
      a(rd.class, "Chicken", 93, 10592673, 16711680);
      a(yo.class, "Wolf", 95, 14144467, 13545366);
      a(of.class, "MushroomCow", 96, 10489616, 12040119);
      a(q.class, "SnowMan", 97, 16777215, 16750916);
      a(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
      a(EntityIronGolem.class, "VillagerGolem", 99, 16777215, 8978312);
      a(EntityVillager.class, "Villager", 120, 5651507, 12422002);
      a(EntityEnderCrystal.class, "EnderCrystal", 200, 16777215, 16751103);
   }
}
