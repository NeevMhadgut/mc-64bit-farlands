import java.util.ArrayList;
import java.util.List;

class ContainerCreative extends dd {
   public List a = new ArrayList();

   public ContainerCreative(EntityPlayer par1EntityPlayer) {
      Block[] ablock = new Block[]{
         Block.w,
         Block.t,
         Block.aw,
         Block.G,
         Block.H,
         Block.I,
         Block.N,
         Block.aN,
         Block.bm,
         Block.bm,
         Block.bm,
         Block.bm,
         Block.aW,
         Block.EntityAIAttackOnCollide,
         Block.ah,
         Block.ai,
         Block.z,
         Block.O,
         Block.BlockPortal,
         Block.GenLayerHills,
         Block.ak,
         Block.ak,
         Block.ak,
         Block.ak,
         Block.ak,
         Block.ak,
         Block.ap,
         Block.ItemBucket,
         Block.EntityAnimal,
         Block.bd,
         Block.J,
         Block.J,
         Block.J,
         Block.J,
         Block.K,
         Block.K,
         Block.K,
         Block.K,
         Block.v,
         Block.u,
         Block.E,
         Block.Q,
         Block.Q,
         Block.Q,
         Block.F,
         Block.W,
         Block.x,
         Block.x,
         Block.x,
         Block.x,
         Block.y,
         Block.y,
         Block.y,
         Block.y,
         Block.Y,
         Block.L,
         Block.aT,
         Block.aU,
         Block.ad,
         Block.BlockTNT,
         Block.TileEntityMobSpawnerRenderer,
         Block.ag,
         Block.aV,
         Block.br,
         Block.ba,
         Block.WorldGenSwamp,
         Block.bu,
         Block.EntityAIMoveIndoors,
         Block.bq,
         Block.bA,
         Block.bB,
         Block.bC,
         Block.bJ,
         Block.by,
         Block.EntityXPOrb,
         Block.X,
         Block.X,
         Block.au,
         Block.StructureNetherBridgeStart,
         Block.M,
         Block.NoiseGeneratorPerlin,
         Block.MapGenVillage,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.ab,
         Block.P,
         Block.aB,
         Block.R,
         Block.aY,
         Block.V,
         Block.Z,
         Block.aZ,
         Block.bv,
         Block.aF,
         Block.aG,
         Block.T,
         Block.U,
         Block.aq,
         Block.at,
         Block.aH,
         Block.bw,
         Block.bx,
         Block.aJ,
         Block.aK,
         Block.aM,
         Block.aQ,
         Block.aR,
         Block.bk,
         Block.bE,
         Block.bL,
         Block.aA,
         Block.aS,
         Block.as,
         Block.EntityPotion,
         Block.be,
         Block.bK,
         Block.bI,
         Block.bH
      };
      int i = 0;
      int j = 0;
      int k = 0;
      int l = 0;
      int i1 = 0;
      int j1 = 0;
      int k1 = 0;
      int l1 = 0;
      int i2 = 1;

      for (int j2 = 0; j2 < ablock.length; j2++) {
         int i3 = 0;
         if (ablock[j2] == Block.ab) {
            i3 = i++;
         } else if (ablock[j2] == Block.ak) {
            i3 = j++;
         } else if (ablock[j2] == Block.J) {
            i3 = k++;
         } else if (ablock[j2] == Block.x) {
            i3 = l++;
         } else if (ablock[j2] == Block.y) {
            i3 = i1++;
         } else if (ablock[j2] == Block.bm) {
            i3 = j1++;
         } else if (ablock[j2] == Block.Q) {
            i3 = k1++;
         } else if (ablock[j2] == Block.X) {
            i3 = i2++;
         } else if (ablock[j2] == Block.K) {
            i3 = l1++;
         }

         this.a.add(new ItemStack(ablock[j2], 1, i3));
      }

      for (int k2 = 256; k2 < Item.e.length; k2++) {
         if (Item.e[k2] != null && Item.e[k2].bQ != Item.bs.bQ && Item.e[k2].bQ != Item.bC.bQ) {
            this.a.add(new ItemStack(Item.e[k2]));
         }
      }

      for (int l2 = 1; l2 < 16; l2++) {
         this.a.add(new ItemStack(Item.aW.bQ, 1, l2));
      }

      for (Integer integer : EntityList.a.keySet()) {
         this.a.add(new ItemStack(Item.bC.bQ, 1, integer));
      }

      aak inventoryplayer = par1EntityPlayer.ap;

      for (int j3 = 0; j3 < 9; j3++) {
         for (int l3 = 0; l3 < 8; l3++) {
            this.a(new yu(sr.g(), l3 + j3 * 8, 8 + l3 * 18, 18 + j3 * 18));
         }
      }

      for (int k3 = 0; k3 < 9; k3++) {
         this.a(new yu(inventoryplayer, k3, 8 + k3 * 18, 184));
      }

      this.a(0.0F);
   }

   public boolean b(EntityPlayer par1EntityPlayer) {
      return true;
   }

   public void a(float par1) {
      int i = this.a.size() / 8 - 8 + 1;
      int j = (int)(par1 * i + 0.5);
      if (j < 0) {
         j = 0;
      }

      for (int k = 0; k < 9; k++) {
         for (int l = 0; l < 8; l++) {
            int i1 = l + (k + j) * 8;
            if (i1 >= 0 && i1 < this.a.size()) {
               sr.g().a(l + k * 8, (ItemStack)this.a.get(i1));
            } else {
               sr.g().a(l + k * 8, null);
            }
         }
      }
   }

   protected void b(int i, int j, boolean flag, EntityPlayer entityplayer) {
   }
}
