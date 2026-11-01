import java.util.HashMap;
import java.util.Map;

public class TileEntity {
   private static Map a = new HashMap();
   private static Map b = new HashMap();
   public World i;
   public long j;
   public int k;
   public long l;
   protected boolean m;
   public int n = -1;
   public Block o;

   private static void a(Class par0Class, String par1Str) {
      if (b.containsKey(par1Str)) {
         throw new IllegalArgumentException("Duplicate id: " + par1Str);
      }

      a.put(par1Str, par0Class);
      b.put(par0Class, par1Str);
   }

   public void a(ady par1NBTTagCompound) {
      try {
         this.j = par1NBTTagCompound.g("x");
      } catch (ClassCastException ex) {
         this.j = par1NBTTagCompound.f("x");
      }

      this.k = par1NBTTagCompound.f("y");

      try {
         this.l = par1NBTTagCompound.g("z");
      } catch (ClassCastException ex) {
         this.l = par1NBTTagCompound.f("z");
      }
   }

   public void b(ady par1NBTTagCompound) {
      String s = (String)b.get(this.getClass());
      if (s == null) {
         throw new RuntimeException(this.getClass() + " EntityAIDoorInteract missing a mapping! This EntityAIDoorInteract a bug!");
      }

      par1NBTTagCompound.a("id", s);
      par1NBTTagCompound.a("x", this.j);
      par1NBTTagCompound.a("y", this.k);
      par1NBTTagCompound.a("z", this.l);
   }

   public void n_() {
   }

   public static TileEntity c(ady par0NBTTagCompound) {
      TileEntity tileentity = null;

      try {
         Class class1 = (Class)a.get(par0NBTTagCompound.j("id"));
         if (class1 != null) {
            tileentity = (TileEntity)class1.newInstance();
         }
      } catch (Exception exception) {
         exception.printStackTrace();
      }

      if (tileentity != null) {
         tileentity.a(par0NBTTagCompound);
      } else {
         System.out.println("Skipping TileEntity with id " + par0NBTTagCompound.j("id"));
      }

      return tileentity;
   }

   public int i() {
      if (this.n == -1) {
         this.n = this.i.getBlockMetadata(this.j, this.k, this.l);
      }

      return this.n;
   }

   public void j() {
      if (this.i != null) {
         this.n = this.i.getBlockMetadata(this.j, this.k, this.l);
         this.i.updateTileEntityChunkAndDoNothing(this.j, this.k, this.l, this);
      }
   }

   public double a(double par1, double par3, double par5) {
      double d = this.j + 0.5 - par1;
      double d1 = this.k + 0.5 - par3;
      double d2 = this.l + 0.5 - par5;
      return d * d + d1 * d1 + d2 * d2;
   }

   public Block k() {
      if (this.o == null) {
         this.o = Block.m[this.i.getBlockId(this.j, this.k, this.l)];
      }

      return this.o;
   }

   public boolean l() {
      return this.m;
   }

   public void h() {
      this.m = true;
   }

   public void m() {
      this.m = false;
   }

   public void b(int i, int j) {
   }

   public void b() {
      this.o = null;
      this.n = -1;
   }

   static {
      a(TileEntityFurnace.class, "Furnace");
      a(TileEntityChest.class, "Chest");
      a(dk.class, "RecordPlayer");
      a(TileEntityDispenser.class, "Trap");
      a(sc.class, "Sign");
      a(TileEntityMobSpawner.class, "MobSpawner");
      a(TileEntityNote.class, "Music");
      a(TileEntityPiston.class, "Piston");
      a(TileEntityBrewingStand.class, "Cauldron");
      a(TileEntityEnchantmentTable.class, "EnchantTable");
      a(bw.class, "Airportal");
   }
}
